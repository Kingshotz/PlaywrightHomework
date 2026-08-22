package ge.tbc.testautomation.data;

public class Constants {

    public static final String BASE_URL = "https://practicesoftwaretesting.com/";
    public static final String REGISTER_URL = BASE_URL + "auth/register";

    public static final String LOGIN_URL_PATTERN = "**/auth/login";
    public static final String ACCOUNT_URL_PATTERN = "**/account";
    public static final String FAVORITES_URL_PATTERN = "**/account/favorites";
    public static final String HAND_TOOLS_URL_PATTERN = "**/category/hand-tools";
    public static final String PRODUCT_URL_PATTERN = "**/product/**";

    // Left sidebar "By category" checkboxes
    public static final String CATEGORY_HAMMER = "Hammer";
    public static final String CATEGORY_HAND_SAW = "Hand Saw";
    public static final String CATEGORY_WRENCH = "Wrench";

    public static final String THOR_HAMMER_PRODUCT_NAME = "Thor Hammer";
    public static final String THOR_HAMMER_CATEGORY_TAG = "Hammer";
    public static final String THOR_HAMMER_BRAND_TAG = "ForgeFlex Tools";

    private Constants() {
    }
}
