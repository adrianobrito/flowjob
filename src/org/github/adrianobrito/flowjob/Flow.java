package org.github.adrianobrito.flowjob;

import java.util.List;

/**
 * Created by adrianobrito on 14/12/15.
 */
public class Flow implements Step{

    private List<? extends Step> steps;
    private Integer currentIndex;

    private Flow(List<? extends Step> steps){
        this.currentIndex = 0;
        this.steps = steps;
    }

    public static Flow create(List<? extends Step> steps){
        return new Flow(steps);
    }

    public Integer currentIndex(){
        return currentIndex;
    }

    public Step currentStep(){
        return steps.get(currentIndex);
    }

    public boolean isFinished(){
        return currentIndex == steps.size();
    }

    public boolean isExecuting(){
        return currentIndex < steps.size();
    }

    public Flow next(){
        Step step = null;

        if(isExecuting()){
            steps.get(currentIndex);
            step.execute();
            currentIndex++;
        } else if(isFinished()){
            throw new FlowException("The flow is already finished");
        }

        return this;
    }

    public void execute(){
        while(isExecuting())
            next();
    }

}
