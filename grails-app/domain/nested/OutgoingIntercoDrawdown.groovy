package nested

import org.grails.gorm.graphql.entity.dsl.GraphQLMapping

class OutgoingIntercoDrawdown {

    String id
    String locationId

    static transients = ['workflow']
    static final String gqlTypeNameQualifier = "OutgoingIntercoDrawdown"

    static graphql = GraphQLMapping.lazy {

        add('workflow','EntityWorkflowDetails'+gqlTypeNameQualifier){
            type {
                // This is my workaround for the second use of EntityWorkflowDetails (unable to collocate gql DSL with POGO properties, and not DRY - 
                // the code below would have to be copied/pasted many times as I have many domain classes that would like to share the same workflow property
                // See IncomingIntercoDrawdown for the nice approach
                field('currentUserTask','EntityWorkflowTask'+'OutgoingIntercoDrawdown'){ //can't use gqlTypeNameQualifier variable below top level: MissingPropertyException
                    field('processInstanceId',String)
                    field('processDefinitionKey', String)
                    field('processName',String)
                    field('assigneeLogon',String)
                    field('assigneeFullName',String)
                    field('currentActivityId',String)
                    field('userTaskName',String)
                    field('progressionOptions','WorkflowTaskProgressionOption'+'OutgoingIntercoDrawdown'){
                        field('nextActivityId',String)
                        field('actionName',String)
                        field('seqFlowId',String)
                        field('assigneeOptions','ProgressionOptionAssignee'+'OutgoingIntercoDrawdown'){
                            field('userLogonOrRole',String)
                            field('userFullNameOrRoleName',String)
                            field('assigneeType',String)
                            collection true
                        }
                        field('commentIsRequired',java.lang.Boolean)
                        collection true
                    }
                }
            }
            dataFetcher { OutgoingIntercoDrawdown intercoDrawdown ->
                return new EntityWorkflowDetails() //real data fetcher builds POGO with all nested objects/properties populated
            }
            input false
        }

    }

    static mapping = {
        table name:'QBOutgoingIntercoDrawdown', schema:'query'
        id generator: 'assigned', sqlType: 'varchar(25)'
        locationId column: 'locationId', sqlType: 'varchar(25)'
    }

    static constraints = {
        id nullable: false
    }

}