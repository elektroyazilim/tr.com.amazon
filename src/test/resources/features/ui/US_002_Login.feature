Feature: The user verifies if the login feature is functional.

  Background: Amazon homepage should be accesable.
    Given the user navigates to "/"
    Then the user verifies if the url contains "amazon.com"
    Then the user verifies if the logo link contains "amazon.com"
    Then the user checks if Orders link is enable
    When the user accepts the cookie
    And the the user hover Accounts section
    Then the user verifies if Sign in popup is open

  @US002_TC_001
  Scenario: TC_001 The user should not able to login with invalid email and missing credential datas
    Then the user verifies if the Giris yap button exists on Homepage
    When the user clicks on the Giris yap button on Homepage
    Then the user verifies if the url contains "signin"
    # clicks the "Devam Et" button when textbox is empty
    When the user clicks on Devam Et button on Login Page
    Then the user verifies if "E-posta adresinizi veya cep telefonu numaranızı girin" message appears
    # user should enter email
    When the user types alphanumeric inputs like "abc12h8" to the email textbox
    And the user clicks on Devam Et button on Login Page
    # Bir sorun oluştu:
    # Bu e-posta adresiyle bir hesap bulamıyoruz
    Then the user verifies if the "Bir sorun oluştu: Bu e-posta adresiyle bir hesap bulamıyoruz" error box appears
    When the user types a valid "email" to the textbox
    And the user clicks on Devam Et button on Login Page
    Then the user verifies if the "Şifre" label exists
    When the user types on textbox any invalid credential password
    And the user clicks on the Giris Yap button on Login Page
    # Bir sorun oluştu
    # Şifreniz yanlış
    Then the user verifies if the "Bir sorun oluştu: Şifreniz yanlış" error box appears

  @US002_TC_002
  Scenario: TC_002 The user should not able to login with invalid phone and missing credential datas
    Then the user verifies if the Giris yap button exists on Homepage
    When the user clicks on the Giris yap button on Homepage
    Then the user verifies if the url contains "signin"
    # user should enter phone
    When the user types the textbox any numbers like "12121"
    And the user clicks on Devam Et button on Login Page
    Then the user verifies if the "Yanlış telefon numarası" error box appears
    When the user types a valid phone number to the textbox
    And the user clicks on Devam Et button on Login Page
    Then the user verifies if the "Şifre" label exists
    # clicks on "Giriş yap" button when the texbox is empty
    When the user clicks on the Giris Yap button on Login Page
    Then the user verifies if "Şifrenizi girin" message appears
    When the user types on textbox any invalid credential password
    And the user clicks on the Giris Yap button on Login Page
    Then the user verifies if the "Bir sorun oluştu: Şifreniz yanlış" error box appears

  @US002_TC_003
  Scenario Outline: TC_003 The user should be able to login with valid credential datas
    Then the user verifies if the Giris yap button exists on Homepage
    When the user clicks on the Giris yap button on Homepage
    Then the user verifies if the url contains "signin"
      # data is below can be "email" or "phone"
    When the user types valid credential "<data>" to the "email" textbox
    And the user clicks on Devam Et button on Login Page
    Then the user verifies if the "Şifre" label exists
    When the user types valid credential "password" to the "password" textbox
    And the user clicks on the Giris Yap button on Login Page
    Then the user verifies if the url contains "nav_signin"
    Examples:
      | data                |
      | eeeyilmaz@gmail.com |
      | 5452816749          |

  # Şifreyi unuttum için de bir scenario outline for negative scenario
  # Şifreyi unuttum için bir pozitif scenario





  # 2. US_ Kullanıcı Giriş Yap section ının fonksiyonel olup olmadığın kontrol eder
  #
  #
  #
  #
  #
  #var olan email
  #olmayan email
  #random karakterle giriş yok
  #
  #var olan telefon
  #olmayan telefon
  #
  #Şifremi unuttum
  #Amazon hesabınızı oluşturun - buton fınksiyonel mi, ilgili sayfa açılıyor mu