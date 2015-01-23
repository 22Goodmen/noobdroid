package za.co.acme.projects.android.template.data.helpers;

import net.sf.oval.ConstraintViolation;

import java.util.List;

/**
 * Created by rishal on 15/01/20.
 */
public interface DataModelValidator {

    boolean isValid();

    List<ConstraintViolation> getConstraintViolations();

}
