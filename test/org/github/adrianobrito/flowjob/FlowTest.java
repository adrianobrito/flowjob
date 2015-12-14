package org.github.adrianobrito.flowjob;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by adrianobrito on 14/12/15.
 */
public class FlowTest {

    @Test
    public void shouldCreateFlow(){
        List<? extends Step> steps = Arrays.asList(new PrintStep("passo 1"),
                                                   new PrintStep("passo 2"),
                                                   new PrintStep("passo 3"));
        Flow flow = Flow.create(steps);
        assertThat(flow, is(notNullValue()));
    }

    @Test
    public void shouldExecuteNextOnFlow(){
        List<? extends Step> steps = Arrays.asList(new PrintStep("passo 1"),
                new PrintStep("passo 2"),
                new PrintStep("passo 3"));

        Flow flow = Flow.create(steps);
        Integer oldIndex = flow.currentIndex();
        flow.next();

        Integer newIndex = flow.currentIndex();

        assertThat(flow, is(notNullValue()));
        assertThat(newIndex, is(not(oldIndex)));
        assertThat(newIndex, is(1));
    }

    @Test
    public void shouldHaveCurrentStep(){
        List<? extends Step> steps = Arrays.asList(new PrintStep("passo 1"),
                new PrintStep("passo 2"),
                new PrintStep("passo 3"));

        Flow flow = Flow.create(steps);

        assertThat(flow.currentStep(), is(steps.get(0)));
    }

    @Test
    public void shouldHaveCurrentIndex(){
        List<? extends Step> steps = Arrays.asList(new PrintStep("passo 1"),
                new PrintStep("passo 2"),
                new PrintStep("passo 3"));

        Flow flow = Flow.create(steps);

        assertThat(flow.currentIndex(), is(0));
    }

    @Test
    public void shouldExecuteAllTheFlow(){
        List<? extends Step> steps = Arrays.asList(new PrintStep("passo 1"),
                new PrintStep("passo 2"),
                new PrintStep("passo 3"));

        Flow flow = Flow.create(steps);
        flow.execute();

        assertThat(flow.isFinished(), is(true));
        assertThat(flow.isExecuting(), is(false));
    }


}
