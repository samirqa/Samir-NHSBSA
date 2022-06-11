Feature: Free NHS Costs for Wales
 Background:

   Scenario Outline: To get the Free NHS Costs to Wales under 16
    Given Opened NHS Costs Checker in "<browser>" and clicked on start button
    When Select country "<country>"
    And Click next
    And select Yes
    And Click next
    When Select country "<country>"
    And Click next
    When Enter invalid BOD "<invalid dob>"
    And Click next
    Then Verify Date Validation
    And Enter valid BOD "<valid dob>"
    And Click next
    Then Show result whether get help from NHS or not

    Examples:
    | browser | country | invalid dob|valid dob |
    | chrome  | wales   |  aa-bb-ccc |13-06-2006|
    | firefox  | wales   | 01-13-222 |13-06-2006|

 Scenario Outline: To get the Free NHS Costs to Wales under 19
  Given Opened NHS Costs Checker in "<browser>" and clicked on start button
  When Select country "<country>"
  And Click next
  And select Yes
  And Click next
  When Select country "<country>"
  And Click next
  And Enter valid BOD "<valid dob>"
  And Click next
  And select Yes
  And Click next
  Then Show result whether get help from NHS or not

  Examples:
   | browser | country | valid dob |
   | chrome  | wales   | 09-06-2005|
   | firefox  | wales  | 09-06-2005|

 Scenario Outline: To get the Free NHS Costs to Wales above 19
  Given Opened NHS Costs Checker in "<browser>" and clicked on start button
  When Select country "<country>"
  And Click next
  ## GP Practice 'Yes'
  And select Yes
  And Click next
  When Select country "<country>"
  And Click next
  And Enter valid BOD "<valid dob>"
  And Click next
  ## Live wtih Partner 'Yes'
  And select Yes
  And Click next
  And Select partner tax claim "<partner taxcliam>"
  And Click next
  # joint Universal Credit
  And Select partner paid for Univarsal Crdit "<univarsal Credit>"
  And Click next
  # LCM
  And select No
  And Click next
  # take-home pay of £935
  And select Yes
  And Click next
  Then Show result whether get help from NHS or not

  Examples:
   | browser | country | valid dob | partner taxcliam|partner paid|univarsal Credit|
   | chrome  | wales   | 09-06-2001| Yes             |Yes      | Yes             |
   | firefox  | wales  | 09-06-2001| Yes             |Yes      | Yes             |