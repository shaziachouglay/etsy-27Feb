Feature: Filter search results using various filter
  A user after entering  location and jobtype can filter the search results using various filters

  @current
  Scenario Outline: Search results using distance filter search
    Given Danny has already performed search for a job by type of job <What> and location <Where>
    When  he filters search results using filter distance <Distance>
    Then  the distance filter should contain <DistanceInMiles>

    Examples:
      | What    | Where  | Distance | DistanceInMiles |
      | Teacher | London | 20       | 20 miles        |

