import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import CustomerApiService  from "../services/RestApiService";

class Login extends Component {
	constructor(props) {
		super(props);

		this.state = {
			email: '',
			password: '',
			error:''
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
		this.setState({
			email: '',
			password: ''
		});
	}

	render() {
		return (
			<div className="login">
				<form onSubmit={this.displayLogin}>
					<h2>Login</h2>
					<div className="username">
						<input
							type="text"
							placeholder="Username..."
							value={this.state.email}
							onChange={this.update}
							name="email"
						/>
					</div>

					<div className="password">
						<input
							type="password"
							placeholder="Password..."
							value={this.state.password}
							onChange={this.update}
							name="password"
						/>
						
					</div>
					<span className="text-danger">{this.state.error}</span>

					{/* <Link to="/Welcome">Go to home</Link> */}
					
					<br></br>
					<br></br>
					<button onClick={() => new CustomerApiService().loginCustomer({email: this.state.email, password: this.state.password})?this.props.history.push('/MakeTrade'):this.setState({error:"username or password is incorrect"})}>Login</button>
				</form>
				<br></br>
				<Link to="/register">Create an account</Link>
			</div>
		);
	}
}

export default Login;
