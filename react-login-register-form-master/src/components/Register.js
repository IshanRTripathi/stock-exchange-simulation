import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import CustomerApiService  from "../services/RestApiService";

class Register extends Component {
	constructor(props) {
		super(props);

		this.state = {
			fullname: '',
			email: '',
			password: ''
		};

		this.update = this.update.bind(this);

		this.displayLogin = this.displayLogin.bind(this);
	}

	update(e) {
		let name = e.target.name;
		let value = e.target.value;
		this.setState({
			[name]: value
		});
	}
	displayLogin(e) {
		e.preventDefault();
		console.log('You have successfully registered');
		console.log(this.state);
		this.setState({
			fullname: '',
			email: '',
			password: ''
		});
	}



	render() {
		return (
			<div className="register">
				<form onSubmit={this.displayLogin}>
					<h2>Register</h2>

					<div className="name">
						<input
							type="text"
							placeholder="Full Name"
							name="fullname"
							value={this.state.fullname}
							onChange={this.update}
						/>
					</div>

					<div className="email">
						<input
							type="text"
							placeholder="Enter your email"
							name="email"
							value={this.state.email}
							onChange={this.update}
						/>
					</div>

					<div className="pasword">
						<input
							type="password"
							placeholder="Password"
							name="password"
							value={this.state.password}
							onChange={this.update}
						/>
					</div>

					<div className="password">
						<input type="password" placeholder="Confirm Password" name="password1" />
					</div>

					<button onClick={() => {new CustomerApiService().addCustomer({fullname: this.state.fullname,email: this.state.email, password: this.state.password})}}>Register</button>
				</form>
				<br></br>
				<Link to="/">Login Here</Link>
			</div>
		);
	}
}

export default Register;
