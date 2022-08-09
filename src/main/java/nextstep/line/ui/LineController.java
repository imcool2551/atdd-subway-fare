package nextstep.line.ui;

import nextstep.line.application.LineService;
import nextstep.line.application.dto.LineRequest;
import nextstep.line.application.dto.LineResponse;
import nextstep.line.application.dto.LineUpdateRequest;
import nextstep.line.application.dto.SectionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nextstep.auth.authorization.secured.Secured;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lines")
public class LineController {
    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<LineResponse> createLine(@RequestBody @Valid LineRequest lineRequest) {
        LineResponse line = lineService.saveLine(lineRequest);
        return ResponseEntity.created(URI.create("/lines/" + line.getId())).body(line);
    }

    @GetMapping
    public List<LineResponse> showLines() {
        return lineService.findLineResponses();
    }

    @GetMapping("/{id}")
    public LineResponse getLine(@PathVariable Long id) {
        return lineService.findLineResponseById(id);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public void updateLine(@PathVariable Long id, @RequestBody @Valid LineUpdateRequest lineRequest) {
        lineService.updateLine(id, lineRequest);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateLine(@PathVariable Long id) {
        lineService.deleteLine(id);
        return ResponseEntity.noContent().build();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/{lineId}/sections")
    public void addSection(@PathVariable Long lineId, @RequestBody @Valid SectionRequest sectionRequest) {
        lineService.addSection(lineId, sectionRequest);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{lineId}/sections")
    public void deleteSection(@PathVariable Long lineId, @RequestParam Long stationId) {
        lineService.deleteSection(lineId, stationId);
    }
}
