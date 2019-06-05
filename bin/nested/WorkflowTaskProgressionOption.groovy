package nested

class WorkflowTaskProgressionOption {

    static final Closure gqlType = {
        field('nextActivityId',String)
        field('actionName',String)
        field('seqFlowId',String)
        field('assigneeOptions','ProgressionOptionAssignee',ProgressionOptionAssignee.gqlType)
        field('commentIsRequired',Boolean)
        collection true
    }

    String nextActivityId
    String actionName
    String seqFlowId
    List<ProgressionOptionAssignee> assigneeOptions
    Boolean commentIsRequired
}