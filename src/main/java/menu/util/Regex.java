package menu.util;

import java.util.regex.Pattern;

public class Regex {
    public static final Pattern COACH_NAMES_PATTERN = Pattern.compile("([ㄱ-ㅎ가-힣]+)(,[ㄱ-ㅎ가-힣]+)*");
}
