'use strict';

class Logout extends React.Component {
	render() {
		return React.createElement(
			"fieldset", 
			null, 
			React.createElement(
				"legend", 
				null, 
				"click for logout"
			), 
			React.createElement(
				"input", 
				{ type: "submit", value: "log out" }
			)
			);
	}
}

ReactDOM.render(
	React.createElement(Logout, null), 
	document.getElementById('logout')
);
