
var arr = new Array("Faculty at AGH",
"Faculty of Mining and Geoengineering",
"Faculty of Metals Engineering and Industrial Computer Science",
"Faculty of Electrical Engineering, Automatics, Computer Science and Biomedical Engineering",
"Faculty of Computer Science, Electronics and Telecommunications",
"Faculty of Mechanical Engineering and Robotics",
"Faculty of Geology, Geophysics and Environmental Protection",
"Faculty of Mining Surveying and Environmental Engineering",
"Faculty of Materials Science and Ceramics",
"Faculty of Foundry Engineering",
"Faculty of Non-Ferrous Metals",
"Faculty of Drilling, Oil and Gas",
"Faculty of Management",
"Faculty of Energy and Fuels",
"Faculty of Physics and Applied Computer Science",
"Faculty of Applied Mathematics",
"Faculty of Humanities",
"Faculty of Energy and Fuels",
"Faculty of Physics and Applied Computer Science",
"Faculty of Applied Mathematics",
"Faculty of Humanities",
"Faculty of Mechanical Engineering and Robotics",
"Faculty of Geology, Geophysics and Environmental Protection",
"Faculty of Mining Surveying and Environmental Engineering",
"Faculty of Materials Science and Ceramics",
"Faculty of Foundry Engineering",);




function populateStates( facultyElementId, stateElementId ){
	
	var selectedfacultyIndex = document.getElementById( facultyElementId ).selectedIndex;

	var stateElement = document.getElementById( stateElementId );
	
	stateElement.length=0;	// Fixed by Julian Woods
	stateElement.options[0] = new Option('Select State','');
	stateElement.selectedIndex = 0;
	
	var state_arr = s_a[selectedfacultyIndex].split("|");
	
	for (var i=0; i<state_arr.length; i++) {
		stateElement.options[stateElement.length] = new Option(state_arr[i],state_arr[i]);
	}
}

function populateCountries(facultyElementId, stateElementId){
	// given the id of the <select> tag as function argument, it inserts <option> tags
	var facultyElement = document.getElementById(facultyElementId);
	facultyElement.length=0;
	facultyElement.options[0] = new Option('Select faculty','-1');
	facultyElement.selectedIndex = 0;
	for (var i=0; i<arr.length; i++) {
		facultyElement.options[facultyElement.length] = new Option(arr[i],arr[i]);
	}

	// Assigned all countries. Now assign event listener for the states.

	if( stateElementId ){
		facultyElement.onchange = function(){
			populateStates( facultyElementId, stateElementId );
		};
	}
}