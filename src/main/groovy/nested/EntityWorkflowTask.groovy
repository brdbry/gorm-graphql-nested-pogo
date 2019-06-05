package nested

class EntityWorkflowTask {

    static final Closure gqlType = {
        field('processInstanceId',String)
        field('processDefinitionKey', String)
        field('processName',String)
        field('assigneeLogon',String)
        field('assigneeFullName',String)
        field('currentActivityId',String)        
        field('userTaskName',String)
        field('progressionOptions','WorkflowTaskProgressionOption',WorkflowTaskProgressionOption.gqlType)
    }

    String processInstanceId
    String processDefinitionKey
    String processName
    String assigneeLogon
    String assigneeFullName
    String currentActivityId   
    String userTaskName
    List<WorkflowTaskProgressionOption> progressionOptions

    public EntityWorkflowTask(){}

}
