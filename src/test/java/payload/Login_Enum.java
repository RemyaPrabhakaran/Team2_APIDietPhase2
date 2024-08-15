package payload;

public class Login_Enum {

	public enum User_Login {
		password ("test"),
		userLoginEmail ("Team2.admin@gmail.com");

		private final String Login;
		User_Login(String value) {
			this.Login = value;
		}
		public String getLogin() {
			return Login;
		}
	}
}
