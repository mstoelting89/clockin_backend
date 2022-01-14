# ToDo

1. User package (x)
   1. UserDomain (x)
   2. UserService (x)
      1. signup method (x)
   3. UserRepository (x)
   4. UserRoleDomain (x)
2. Security package (x)
   1. WebConfig (x)
3. Registration package
   1. RegistrationService
      1. register - method
         1. validate email (x)
         2. call sign up method (x)
         3. send mail
      2. email - text
      3. confirm token - method
   2. RegistrationDto (x)
   3. RegistrationController (x)
      1. confirm token endpoint
4. Token / Email package
   1. Create Token Domain (x)
      1. id
      2. token (string)
      3. createdAt
      4. expireAt
      5. confirmedAt
   2. Create Token Repository (x)
   3. Create Token Service 
      1. get Token (x)
      2. set ConfirmedAt (x)
      3. save Token (x)
   4. Set enabled in User Table