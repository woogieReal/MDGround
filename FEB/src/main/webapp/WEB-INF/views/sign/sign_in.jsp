<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="eachPart">
	<div class="sign_entire_div">
		<main class="form-signin">
			<form>
				<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
				<div class="form-floating">
					<input type="email" class="form-control" id="email" placeholder="name@example.com">
					<label for="memberId">Email address</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="pw" placeholder="Password">
					<label for="pw">Password</label>
				</div>
			</form>
	
			<div>
				<button id="signInBtn" onclick="doSignIn();" class="w-100 btn btn-lg btn-primary btn-enhance" type="submit" style="margin-bottom: 15px;">Sign in</button>
				<button id="signUpBtn" onclick="doMoveToSignUp();" class="w-100 btn btn-lg btn-primary btn-enhance" type="submit">Sign up</button>
			</div>
			<p class="mt-5 mb-3 text-muted">&copy; ENHANCE</p>
	
		</main>
	</div>
</div>