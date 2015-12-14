package org.github.adrianobrito.flowjob;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/**
 * Created by adrianobrito on 13/11/15.
 */
public class CheckTest {

    @Test
    public void shouldCreateConditionalWithCheck(){
        Conditional conditional = new Conditional() {
            @Override
            public boolean test() {
                return true;
            }
        };

        Step step = Check.the(conditional);
        assertThat(step, is(notNullValue()));
    }

    @Test
    public void shouldCreateConditionalCheckWithCases(){
        Conditional conditional = new Conditional() {
            @Override
            public boolean test() {
                return true;
            }
        };
        Step caseSuccess = new Step() {
            @Override
            public void execute() {
                System.out.println("Success");
            };
        };
        Step caseFail = new Step() {
            @Override
            public void execute() {
                System.out.println("Success");
            };
        };

        Step step = Check.the(conditional)
                         .caseSuccess(caseSuccess)
                         .caseFail(caseFail);

        assertThat(step, is(notNullValue()));
    }

    @Test
    public void shouldExecuteAsStep(){
        Conditional conditional = new Conditional() {
            @Override
            public boolean test() {
                return true;
            }
        };
        Step caseSuccess = new Step() {
            @Override
            public void execute() {
                System.out.println("Success");
            };
        };
        Step caseFail = new Step() {
            @Override
            public void execute() {
                System.out.println("Fail");
            };
        };

        Step step = Check.the(conditional)
                .caseSuccess(caseSuccess)
                .caseFail(caseFail);

        step.execute();
        assertThat(step, is(notNullValue()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldNotExecuteWithoutCases(){
        Conditional conditional = new Conditional() {
            @Override
            public boolean test() {
                return true;
            }
        };
        Step step = Check.the(conditional);

        step.execute();
    }

}
