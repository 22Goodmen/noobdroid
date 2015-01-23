package za.co.acme.projects.android.template.data.helpers;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.List;


/**
 * Created by rishal on 15/01/20.
 */
public abstract class AbstractDataModel<T> extends SugarRecord<T> implements DataModelValidator {

    @Ignore
    private Validator validator;

    public AbstractDataModel() {
        validator = new Validator();
    }

    @Override
    public List<ConstraintViolation> getConstraintViolations() {
        return validator.validate(this);
    }

    @Override
    public boolean isValid() {
        if (getConstraintViolations().size() > 0) {
            return false;
        }
        return true;
    }

}
