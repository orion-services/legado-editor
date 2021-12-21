//cy.visit('https://discord.com/channels/817064619923341322/817064619923341324');
describe('Discord', () => {
    beforeEach(() => {

        cy.visit('https://discord.com/login');

    });

    it('login`', () => {
      cy.get('input[name="email"]').type('guilherme.smoreira@hotmail.com');
      cy.get('input[name="password"]').type('testguilherme');
      cy.contains('Login').click();
    });
  

  });