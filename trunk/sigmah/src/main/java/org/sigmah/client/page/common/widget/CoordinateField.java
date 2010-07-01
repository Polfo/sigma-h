/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.page.common.widget;


import com.extjs.gxt.ui.client.widget.form.TextField;
import org.sigmah.client.i18n.I18N;

public class CoordinateField extends TextField<Double> {

	public final static int LATITUDE = 1;
	public final static int LONGITUDE = 2;

    /**
     * Because of the conversion between DMS and degrees decimal,
     * we may loose some precision. This becomes a problem when the
     * coordinate is clamped to the adminstrative bounds, and the
     * resulting value is *exactly* on the boundary. When rounded,
     * the coordinate can fall on the wrong side of the boundary,
     * resulting in a validation error.
     *
     * The delta value below should be sufficient to allow for such
     * imprecision.
     */
    public final static double DELTA = 0.00001;
	
	private CoordinateEditor editor;
	
	
	public CoordinateField(int axis) {
		super();
        if(axis == LATITUDE) {
            editor = new CoordinateEditor(I18N.CONSTANTS.southHemiChars(), I18N.CONSTANTS.northHemiChars());
        } else {
            editor = new CoordinateEditor(I18N.CONSTANTS.westHemiChars(), I18N.CONSTANTS.eastHemiChars());
        }
		this.setPropertyEditor(editor);
        this.setValidator(editor);
        this.setValidateOnBlur(true);
        
	}

	public void setBounds(String name, double minValue, double maxValue) {
		editor.setMinValue(minValue - DELTA);
		editor.setMaxValue(maxValue + DELTA);
        editor.setOutOfBoundsMessage(I18N.MESSAGES.coordOutsideBounds(name));
	}
}
