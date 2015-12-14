package org.github.adrianobrito.flowjob;

/**
 * Created by adrianobrito on 14/12/15.
 */
public class Check implements Step{

    private Step onSuccess;
    private Step onFail;
    private Conditional conditional;

    private Check(Conditional conditional) { this.conditional = conditional; }
    private Check(Conditional conditional, Step onSuccess, Step onFail) {
        this.conditional = conditional;
        this.onSuccess = onSuccess;
        this.onFail = onFail;
    }


    @Override
    public void execute() {
        if(onSuccess == null)
            throw new UnsupportedOperationException("Check has any Successful case step");
        else if(onFail == null)
            throw new UnsupportedOperationException("Check has any Fail case step");


        if(conditional.test())
            onSuccess.execute();
        else
            onFail.execute();
    }

    public static Check the(Conditional conditional){
        Check check = new Check(conditional);
        return check;
    }

    public static Check the(Conditional conditional, Step onSuccess, Step onFail){
        Check check = new Check(conditional, onSuccess, onFail);
        return check;
    }

    public Check caseSuccess(Step onSuccess){
        this.onSuccess = onSuccess;
        return this;
    }

    public Check caseFail(Step onFail){
        this.onFail = onFail;
        return this;
    }


}
