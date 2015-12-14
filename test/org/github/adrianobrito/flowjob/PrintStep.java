package org.github.adrianobrito.flowjob;

/**
 * Created by adrianobrito on 14/12/15.
 */
public class PrintStep implements Step{

    private String message;

    public PrintStep(String message){
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }

}
