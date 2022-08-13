package nextstep.path.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FareCalculatorTest {

    private final FareCalculator calculator = new FareCalculator();

    @DisplayName("요금 계산")
    @ParameterizedTest
    @CsvSource({
            "10,1250", // 10km 미만일 때 기본 운임
            "11,1350", // 10km 초과시 5km 마다 100원 추가
            "15,1450",
            "45,2050",
            "50,2150", // 50km 부터 8km 마다 100원 추가
            "58,2250",
    })
    void calculateFare(int distance, int expectedFare) {
        assertThat(calculator.calculateFare(distance)).isEqualTo(expectedFare);
    }
}
