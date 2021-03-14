
  Feature: Search for Jobs


    Scenario Outline: Search by location
      Given Ariel a non registered user has opened the reed application
      When  she searches for job by type of job "<What>" and location "<Where>"
      Then  she should be able to see jobs related to the type of job searched for "<What>"
      Examples:
        | What    | Where  |
        | Teacher | London |

    @current

      Scenario Outline: Filter search results by job type
        Given Danny has already performed search for a job by type of job <What> and location <Where>
        When he filters the search result using filter of <Job Type>
        Then he should be able to see jobs search results containing <Job Type>
        Examples:
          | Job Type |What|Where|
          |Permanent |Teacher|London|