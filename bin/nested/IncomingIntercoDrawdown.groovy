package nested

import org.grails.gorm.graphql.entity.dsl.GraphQLMapping

class IncomingIntercoDrawdown {
    
    String id
    Strning locationId

    static transients = ['workflow']

    static graphql = GraphQLMapping.lazy {

        //This is my desired approach (using nested closures to colocate properties and gql DSL), which worked fine for the first use of EntityWorkflowDetails
        //See OutgoingIntercoDrawdown for the workaround
        add('workflow','EntityWorkflowDetails'){
            type EntityWorkflowDetails.gqlType
            dataFetcher { IncomingIntercoDrawdown intercoDrawdown ->
                return new EntityWorkflowDetails() //real data fetcher builds POGO with all nested objects/properties populated
            }
            input false
        }

    }

    static mapping = {
        table name:'QBIncomingIntercoDrawdown', schema:'query'
        id generator: 'assigned', sqlType: 'varchar(25)'
        locationId column: 'locationId', sqlType: 'varchar(25)'
    }

    static constraints = {
        id nullable: false
     }

 
}

```