package com.junitseleniumpr.pageclasses;

import com.junitseleniumpr.Steplmplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageFirst extends Steplmplementation {
    @Test
    @DisplayName("Bu test url e gittiğini doğrular.")
    public void verificateGoToURL(){
        gotoUrl();
    }
}
