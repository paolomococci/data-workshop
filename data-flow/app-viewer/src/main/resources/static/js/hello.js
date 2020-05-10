'use strict';

class Hello extends React.Component {
	render() {
		return React.createElement(
				"h2", 
				null, 
				"Hello ", 
				this.props.name
		);
	}
}

ReactDOM.render(
		React.createElement(Hello, {name: "World"}), 
		document.getElementById('hello')
);
