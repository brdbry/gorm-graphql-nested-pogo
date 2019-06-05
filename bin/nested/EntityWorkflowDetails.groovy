package nested

class EntityWorkflowDetails {

    static final Closure gqlType = {
        field('currentUserTask','EntityWorkflowTask', EntityWorkflowTask.gqlType)
    }

    EntityWorkflowTask currentUserTask

}



