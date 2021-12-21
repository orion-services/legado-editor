//cy.visit('https://discord.com/channels/817064619923341322/817064619923341324');
describe('Discord', () => {   
    it('discord`', () => {
        cy.visit('https://discord.com/login');
    });

    it('discord login`', () => {
      cy.get('input[name="email"]').type('guilherme.smoreira@hotmail.com');
      cy.get('input[name="password"]').type('testguilherme');
      cy.contains('Login').click();
    });

    /** 
        after logging in, the user will go to the discord server where he will have the bot, 
        there he will do the commands
    */

  
    it("blockly", () => {
        cy.visit("/");
    });
    
  });