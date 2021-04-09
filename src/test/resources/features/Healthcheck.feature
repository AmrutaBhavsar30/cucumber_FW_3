@ui @healthcheck

Feature: Automation practice


  @URLredirection    
  Scenario: user is able to redirect to landing page url
    Given User Opend the application url
    When  user is on appllication main page  
    Then user navigate to landing page url: "http://automationpractice.com/index.php"
    
        
    @titleValidation
    Scenario: validate landing page title
   Given User Opend the application url
    When  user is on appllication main page  
    Then application title should be "My Store"
    
    @LogoDisplay
    Scenario: validate logo is diplay or not
    When User open the browser
    Then application logo should be displayed
    
     @LogoHeight
    Scenario: validate apllication logo height
    When User open the browser
    Then application logo height should be "99"
    

  @LogoWidth
    Scenario: validate apllication logo width
    When User open the browser
    Then application logo width should be "350"
    
    
  