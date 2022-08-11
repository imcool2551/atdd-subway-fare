package nextstep.line.application;

import nextstep.line.application.dto.LineRequest;
import nextstep.line.application.dto.LineResponse;
import nextstep.line.application.dto.LineUpdateRequest;
import nextstep.line.application.dto.SectionRequest;
import nextstep.line.domain.Line;
import nextstep.line.domain.LineRepository;
import nextstep.station.application.StationService;
import nextstep.station.domain.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class LineService {
    private final LineRepository lineRepository;
    private final StationService stationService;

    public LineService(LineRepository lineRepository, StationService stationService) {
        this.lineRepository = lineRepository;
        this.stationService = stationService;
    }

    @Transactional
    public LineResponse saveLine(LineRequest request) {
        Line line = lineRepository.save(new Line(request.getName(), request.getColor()));
        if (containsInitialSection(request)) {
            Station upStation = stationService.findById(request.getUpStationId());
            Station downStation = stationService.findById(request.getDownStationId());
            line.addSection(upStation, downStation, request.getDistance(), request.getDuration());
        }

        return createLineResponse(line);
    }

    private boolean containsInitialSection(LineRequest request) {
        return request.getUpStationId() != null
                && request.getDownStationId() != null
                && request.getDistance() != null
                && request.getDuration() != null;
    }

    public Line findById(Long id) {
        return lineRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Line> findLines() {
        return lineRepository.findAll();
    }

    public LineResponse findLineResponseById(Long id) {
        return createLineResponse(findById(id));
    }

    public List<LineResponse> findLineResponses() {
        return lineRepository.findAll()
                .stream()
                .map(this::createLineResponse)
                .collect(Collectors.toList());
    }

    public LineResponse createLineResponse(Line line) {
        List<Station> stations = stationService.findAllStationsById(line.getStations());
        return LineResponse.of(line, stations);
    }

    @Transactional
    public void updateLine(Long id, LineUpdateRequest lineRequest) {
        Line line = findById(id);
        line.update(lineRequest.getName(), lineRequest.getColor());
    }

    @Transactional
    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }

    @Transactional
    public void addSection(Long lineId, SectionRequest request) {
        Station upStation = stationService.findById(request.getUpStationId());
        Station downStation = stationService.findById(request.getDownStationId());
        assert upStation != null && downStation != null;

        Line line = findById(lineId);
        line.addSection(request.toEntity());
    }

    @Transactional
    public void deleteSection(Long lineId, Long stationId) {
        Line line = findById(lineId);
        Station station = stationService.findById(stationId);

        line.deleteSection(station);
    }
}
