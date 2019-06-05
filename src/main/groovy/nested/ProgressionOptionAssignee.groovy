package nested

class ProgressionOptionAssignee {

    static final Closure gqlType = {
        field('userLogonOrRole',String)
        field('userFullNameOrRoleName',String)
        field('assigneeType',String)
        collection true
    }

    String userLogonOrRole
    String userFullNameOrRoleName
    String assigneeType //'role' or 'user'

    public ProgressionOptionAssignee(){}

}