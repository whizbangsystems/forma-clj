package forma;

import cascalog.CascalogFunction;
import cascading.operation.FunctionCall;
import cascading.operation.OperationCall;
import cascading.flow.FlowProcess;
import cascading.tuple.Tuple;

public class AddYearFunction extends CascalogFunction {

    private String fileName;

    public void prepare(FlowProcess flowProcess, OperationCall operationCall) {

        // check on the value of flowProcess -- returns null!
        // Object name = flowProcess.getProperty( "map.input.file" );
        System.out.println(flowProcess.getProperty("map.input.file"));
        System.out.println(flowProcess.getProperty("map.input.length"));
        System.out.println(flowProcess.getProperty("map.input.file"));
        System.out.println(flowProcess.getProperty("mapred.task.id"));
    }

    public void operate(FlowProcess flowProcess, FunctionCall functionCall) {

        // Checking this flowProcess, just in case
        Object name = flowProcess.getProperty( "map.input.file" );
        System.out.println(name);

        // Just to get some output
        Tuple result = new Tuple();
        result.add( "Happy" );
        functionCall.getOutputCollector().add( result );
    }
}