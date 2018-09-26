package com.techhub.web.viewResolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.techhub.web.view.ExcelView;

/**
 * View resolver for excel export.
 */
public class ExcelViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        return new ExcelView();
    }
}
