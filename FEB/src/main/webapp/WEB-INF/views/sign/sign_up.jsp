<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="eachPart">
    <div class="sign_entire_div">  
	  <main class="form-signin">
	  
		<div class="py-5 text-center">
		  <h2>Sign up</h2>
		</div>

        <form id="signUpFrm" name="signUpFrm">
        <input type="hidden" name="idCheckFlag" id="idCheckFlag" value="">
	  	<input type="hidden" name="checkedId" id="checkedId" value="">
	  	
          <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="button" onclick="doCheckDuplicatedId();" class="btn btn-primary btn-sm btn-right" value="Check" id="idCheckBtn" />
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter your email address to use as login ID">
          </div>
          <div class="mb-3">
            <label for="pw" class="form-label">Password</label>
            <input type="password" class="form-control"  placeholder="7 and 15 characters with at least one number" id="pw">
          </div>
          <div class="mb-3">
            <label for="pw_check" class="form-label">Confirm Password</label>
            <input type="password" class="form-control" id="pw_check">
          </div>
          <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name">
          </div>
          <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <select class="form-select form-select-lg mb-3" style="font-size: medium;" id="location" aria-label=".form-select-lg example">
				<option value="Austria">Austria</option>
				<option value="Australia">Australia</option>
				<option value="Belgium">Belgium</option>
				<option value="Canada">Canada</option>
				<option value="Chile">Chile</option>
				<option value="Colombia">Colombia</option>
				<option value="CzechRepublic">CzechRepublic</option>
				<option value="Denmark">Denmark</option>
				<option value="Estonia">Estonia</option>
				<option value="Finland">Finland</option>
				<option value="France">France</option>
				<option value="Germany">Germany</option>
				<option value="Greece">Greece</option>
				<option value="Hungary">Hungary</option>
				<option value="Iceland">Iceland</option>
				<option value="Ireland">Ireland</option>
				<option value="Israel">Israel</option>
				<option value="Italy">Italy</option>
				<option value="Japan">Japan</option>
				<option value="Korea" selected="selected">Korea</option>
				<option value="Latvia">Latvia</option>
				<option value="Lithuania">Lithuania</option>
				<option value="Luxembourg">Luxembourg</option>
				<option value="Mexico">Mexico</option>
				<option value="theNetherlands">theNetherlands</option>
				<option value="NewZealand">New Zealand</option>
				<option value="Norway">Norway</option>
				<option value="Poland">Poland</option>
				<option value="Portugal">Portugal</option>
				<option value="Slovak">Slovak</option>
				<option value="Republic">Republic</option>
				<option value="Slovenia">Slovenia</option>
				<option value="Spain">Spain</option>
				<option value="Sweden">Sweden</option>
				<option value="Switzerland">Switzerland</option>
				<option value="Turkey">Turkey</option>
				<option value="theUnitedKingdom">the United Kingdom</option>
				<option value="theUnitedStates">the United States</option>            
            </select>
          </div>
        </form>
          <button type="submit" onclick="doSignUp();" class="btn btn-primary">Sign up</button><br/><br/>
	  </main>	
    </div>
  </div>