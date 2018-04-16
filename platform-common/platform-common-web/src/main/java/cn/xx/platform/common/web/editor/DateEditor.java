package cn.xx.platform.common.web.editor;

import cn.xx.platform.common.utils.DateHelper;

import java.beans.PropertyEditorSupport;

/**
 *
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
