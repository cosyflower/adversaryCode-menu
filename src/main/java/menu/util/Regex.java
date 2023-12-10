package menu.util;

import java.util.regex.Pattern;

public class Regex {
    public static final Pattern COACH_NAMES_PATTERN = Pattern.compile("(\\w+)(,\\w+)*");
}
