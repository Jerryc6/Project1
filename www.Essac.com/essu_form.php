
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="essuform.css">
</head>
<body>
    <!--This is Title-->
    <div class="header-title">
        <div class="essupic">
            <img src="" alt="" sizes="" srcset="">
        </div>
        <h1>UNIVERSITY ADMMISION APPLICATION FORM</h1>
        <p class="header-title-p">(Undergraduate Program)</p>
    </div>

    <form action="inputdataindatabase.php" method="post" autocomplete="off" enctype="multipart/form-data">
        <div class="first-box-content">
            <div class="field-apan">
                
                <div class="app-ref-no">
                    <input type="text" placeholder="APP_REF NO." name="apprefno" id="apprefno">
                </div>

                <div class="schoolYear-campus">
                    <input type="text" placeholder="SCHOOL YEAR" name="school_year" id="school_year">
                    <input type="text" placeholder="CAMPUS" name="cam_pus" id="cam_pus">
                </div>

                <div class="degree-choice">
                    <p class="surat">DEGREE/PROGRAM CHOICE</p>
                    <p class="first-choice">FIRST CHOICE</p>

                    <div class="first-c">
                        <select name="ferst_degree" id="ferst_degree">
                            <option value="Ph.D. in Educational Management">Ph.D. in Educational Management</option>
                            <option value="M.A. in Teaching Vocational Education (MATVE)">M.A. in Teaching Vocational Education (MATVE)</option>
                            <option value="M.A. in Management (MAM)">M.A. in Management (MAM)</option>
                            <option value="M.A. in Education (MAEd)">M.A. in Education (MAEd)</option>
                            <option value="Bachelor of Science in Agriculture">Bachelor of Science in Agriculture</option>
                            <option value="Bachelor of Science in Agribusiness">Bachelor of Science in Agribusiness</option>
                            <option value="Bachelor of Science in Environmental Science">Bachelor of Science in Environmental Science</option>
                            <option value="Bachelor of Science in Computer Engineering">Bachelor of Science in Computer Engineering</option>
                            <option value="Bachelor of Science in Agricultural & Biosystems Engineering">Bachelor of Science in Agricultural & Biosystems Engineering</option>
                            <option value="Bachelor of Science in Computer Science">Bachelor of Science in Computer Science</option>
                            <option value="Bachelor of Science in Information Technology">Bachelor of Science in Information Technology</option>
                            <option value="Bachelor of Early Childhood Education">Bachelor of Early Childhood Education</option>
                            <option value="Bachelor of Elementary Education">Bachelor of Elementary Education</option>
                            <option value="Bachelor of Secondary Education Majors: English Mathematics Science">Bachelor of Secondary Education Majors: English Mathematics Science</option>
                            <option value="Bachelor of Technology & Livelihood Education Majors: ICT & Home Economics">Bachelor of Technology & Livelihood Education Majors: ICT & Home Economics</option>
                        </select>
                    </div>

                    <p class="seconnd-choice">SECOND CHOICE</p>
                    <div class="second-c">
                        <select name="sicond_degree" id="sicond_degree">
                            <option value="Ph.D. in Educational Management">Ph.D. in Educational Management</option>
                            <option value="M.A. in Teaching Vocational Education (MATVE)">M.A. in Teaching Vocational Education (MATVE)</option>
                            <option value="M.A. in Management (MAM)">M.A. in Management (MAM)</option>
                            <option value="M.A. in Education (MAEd)">M.A. in Education (MAEd)</option>
                            <option value="Bachelor of Science in Agriculture">Bachelor of Science in Agriculture</option>
                            <option value="Bachelor of Science in Agribusiness">Bachelor of Science in Agribusiness</option>
                            <option value="Bachelor of Science in Environmental Science">Bachelor of Science in Environmental Science</option>
                            <option value="Bachelor of Science in Computer Engineering">Bachelor of Science in Computer Engineering</option>
                            <option value="Bachelor of Science in Agricultural & Biosystems Engineering">Bachelor of Science in Agricultural & Biosystems Engineering</option>
                            <option value="Bachelor of Science in Computer Science">Bachelor of Science in Computer Science</option>
                            <option value="Bachelor of Science in Information Technology">Bachelor of Science in Information Technology</option>
                            <option value="Bachelor of Early Childhood Education">Bachelor of Early Childhood Education</option>
                            <option value="Bachelor of Elementary Education">Bachelor of Elementary Education</option>
                            <option value="Bachelor of Secondary Education Majors: English Mathematics Science">Bachelor of Secondary Education Majors: English Mathematics Science</option>
                            <option value="Bachelor of Technology & Livelihood Education Majors: ICT & Home Economics">Bachelor of Technology & Livelihood Education Majors: ICT & Home Economics</option>
                        </select>
                    </div>


                    <p class="third-choice">THIRD CHOICE</p>
                    <div class="third-c">
                        <select name="therd_degree" id="therd_degree">
                            <option value="Ph.D. in Educational Management">Ph.D. in Educational Management</option>
                            <option value="M.A. in Teaching Vocational Education (MATVE)">M.A. in Teaching Vocational Education (MATVE)</option>
                            <option value="M.A. in Management (MAM)">M.A. in Management (MAM)</option>
                            <option value="M.A. in Education (MAEd)">M.A. in Education (MAEd)</option>
                            <option value="Bachelor of Science in Agriculture">Bachelor of Science in Agriculture</option>
                            <option value="Bachelor of Science in Agribusiness">Bachelor of Science in Agribusiness</option>
                            <option value="Bachelor of Science in Environmental Science">Bachelor of Science in Environmental Science</option>
                            <option value="Bachelor of Science in Computer Engineering">Bachelor of Science in Computer Engineering</option>
                            <option value="Bachelor of Science in Agricultural & Biosystems Engineering">Bachelor of Science in Agricultural & Biosystems Engineering</option>
                            <option value="Bachelor of Science in Computer Science">Bachelor of Science in Computer Science</option>
                            <option value="Bachelor of Science in Information Technology">Bachelor of Science in Information Technology</option>
                            <option value="Bachelor of Early Childhood Education">Bachelor of Early Childhood Education</option>
                            <option value="Bachelor of Elementary Education">Bachelor of Elementary Education</option>
                            <option value="Bachelor of Secondary Education Majors: English Mathematics Science">Bachelor of Secondary Education Majors: English Mathematics Science</option>
                            <option value="Bachelor of Technology & Livelihood Education Majors: ICT & Home Economics">Bachelor of Technology & Livelihood Education Majors: ICT & Home Economics</option>
                        </select>
                    </div>
                    
                </div>
    
                
            </div>

            <div class="knan-picture">
                <div class="hero">
                    <div class="card">
                            <img src="pic/pro.jpg" id="profile-pic">
                         <!--<label for="input-file">Choose Image</label>-->
                         <label for="input-file" class="tt">
                            <p>Upload Image</p>
                         </label>
                        <input type="file" accept="image/jpeg, image/png, image/jpg" id="input-file" name="sendpic" value="">
                    </div>
                </div>  
            </div>

        </div>




        <div class="second-boxx">
            <div class="name-info">
                <input type="text" placeholder="Family Name" name="famely_name" id="famely_name">
                <input type="text" placeholder="First Name" name="ferst_name" id="ferst_name">
                <input type="text" placeholder="Middle Name" name="meddli_name" id="meddli_name">
            </div>

            <div class="contact-info">
                <input type="email" placeholder="Email Address" name="Imail_addresss" id="Imail_addresss">
                <input type="number" placeholder="Contact Number" name="cuntact" id="cuntact">
            </div>

            <div class="student-info">
                <p class="info">Date of Birth</p>

                <div class="knanbirth">
                    <div class="dropdown-month">
                        <select name="munth" id="munth">
                            <option value="JANUARY">JANUARY</option>
                            <option value="FEBRUARY">FEBRUARY</option>
                            <option value="MARCH">MARCH</option>
                            <option value="APRIL">APRIL</option>
                            <option value="MAY">MAY</option>
                            <option value="JUNE">JUNE</option>
                            <option value="JULY">JULY</option>
                            <option value="AUGUST">AUGUST</option>
                            <option value="SEPTEMBER">SEPTEMBER</option>
                            <option value="OCTOBER">OCTOBER</option>
                            <option value="NOVEMBER">NOVEMBER</option>
                            <option value="DECEMBER">DECEMBER</option>
                        </select>
                    </div>
    
                    <div class="dropdown-day">
                       <select name="dey" id="dey">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                       </select>
                    </div>
    
    
                    <div class="dropdown-year">
                        <select name="yier" id="yier">
                            <option value="1995">1995</option>
                            <option value="1996">1996</option>
                            <option value="1997">1997</option>
                            <option value="1998">1998</option>
                            <option value="1999">1999</option>
                            <option value="1999">2000</option>
                            <option value="2001">2001</option>
                            <option value="2002">2002</option>
                            <option value="2003">2003</option>
                            <option value="2004">2004</option>
                            <option value="2005">2005</option>
                            <option value="2006">2006</option>
                            <option value="2007">2007</option>
                            <option value="2008">2008</option>
                            <option value="2009">2009</option>
                            <option value="2010">2010</option>
                            <option value="2011">2011</option>
                            <option value="2012">2012</option>
                            <option value="2013">2013</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                            <option value="2016">2016</option>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                            <option value="2020">2020</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                            <option value="2025">2025</option>
                            <option value="2026">2026</option>
                        </select>
                    </div>

                    <div class="dropdown-sex">
                        <select name="six" id="six">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>

                    <div class="dropdown-status">
                        <select name="sttatus" id="sttatus">
                            <option value="Married">Married</option>
                            <option value="Single">Single</option>
                            <option value="Widowed">Widowed</option>
                            <option value="Divorce">Divorce</option>
                        </select>
                    </div>

                    <div class="inputtown">
                        <input type="text" placeholder="PLACE OF BIRTH (Town, Province)" name="tawn" id="tawn">
                    </div>
                </div>

            </div>


            <div class="info-location">
                <p class="pd">PERMANENT ADDRESS</p>
                <input type="text" placeholder="BARANGAY" name="brgy" id="brgy"> 
                <input type="text" placeholder="MUNICIPALITY" name="bungto" id="bungto">
                <input type="text" placeholder="PROVINCE" name="province" id="province">
            </div>

            <div class="last-attended-record">
                <p class="la">LAST SCHOOL ATTENDED</p>
                <input type="text" placeholder="NAME OF SCHOOL" name="name_school" id="name_school">
                <input type="text" placeholder="ADDRESS" name="address_school" id="address_school">
                <input type="text" placeholder="YEAR" name="highschool_year" id="highschool_year">
                <input type="text" placeholder="GEN. AVERAGE" name="gen_average" id="gen_average">
            </div>
        </div>



        <div class="thirdBox">
            <div class="third-content">
                <div class="first-question">
                    <p class="dl">Declartion</p>
                    <p class="firstt-question">Do you have a physical condition which may affect your performance in College?</p>

                    <div class="yes-no">  
                        <label class="yesNo">
                            <input type="checkbox" name="fcheckboxyes" id="fcheckboxyes" value="yes">
                            <span class="checkmark"></span>
                            Yes
                        </label> 
   
                        <label class="yesNo">
                            <input type="checkbox" name="fcheckboxno" value="no">
                            <span class="checkmark"></span>
                            No
                        </label> 
                    </div>

                    <div class="text-area">
                        <textarea name="firstcomment" id="firstcomment" class="first-comment" placeholder="If yes, please state the physical conditon....."></textarea>
                    </div>

                </div>

                <div class="second-question">
                  <p class="sec-q">Have you been subjected to any disciplinary action?</p>
                    <div class="yes-no">
                        <label class="yesNoo">
                            <input type="checkbox" name="seccheckboxyes" value="yes">
                            <span class="checkmark"></span>
                             Yes
                          </label> 
      
                          <label class="yesNoo">
                            <input type="checkbox" name="secheckboxno" value="no">
                            <span class="checkmark"></span>
                             No
                          </label> 
                    </div>


                    <div class="text-area-sec">
                        <textarea name="secondcomment" class="second-comment" placeholder="If yes, please state the disciplinry action....."></textarea>
                    </div>
                </div>

                <div class="third-question">
                  <p class="third-q">The information on this form will be used in accordance with the Uniersity's policy on personal data</p>
                  <p class="I-certify">I certify that the information above is true, complete and correct. I understand that falsification or with holding of information on this form will nullify and/or subject me to dismissal from the University.</p>
                  
                </div>

            </div>
        </div>

        <div class="sub">
            <button type="submit" name="submit" class="btn-sub">CLEAR</button>
            <button class="btn-clear" type="submit" name="submit" >SUBMIT</button>
        </div>

    </form>

    <footer>
        
    </footer>

    

    <script>
        let ProfilePic = document.getElementById("profile-pic");
        let InputFile = document.getElementById("input-file");  
        InputFile.onchange = function(){
            ProfilePic.src = URL.createObjectURL(InputFile.files[0]);
        }
    </script>
</body>
</html>
