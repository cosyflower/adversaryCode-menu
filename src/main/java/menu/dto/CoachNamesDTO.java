package menu.dto;

import java.util.Arrays;
import java.util.stream.Collectors;
import menu.coach.CoachNames;
import menu.util.Regex;

public class CoachNamesDTO {
    private final String coachNamesDTO;

    public CoachNamesDTO(String coachNamesDTO) {
        validateCoachNamesDTO(coachNamesDTO);
        this.coachNamesDTO = coachNamesDTO;
    }

    private void validateCoachNamesDTO(String coachNamesDTO) {
        isNullOrEmpty(coachNamesDTO);
        hasCoachNamesPattern(coachNamesDTO);
    }

    private void isNullOrEmpty(String coachNamesDTO) {
        if (coachNamesDTO == null || coachNamesDTO.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요.");
        }
    }

    private void hasCoachNamesPattern(String coachNamesDTO) {
        if (Regex.COACH_NAMES_PATTERN.matcher(coachNamesDTO).matches()) {
            return;
        }
        throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해주세요.");
    }

    public CoachNames toCoachNames() {
        String[] splitCoachNames = coachNamesDTO.split(",");
        return new CoachNames(Arrays.stream(splitCoachNames)
                .collect(Collectors.toList()));
    }
}
