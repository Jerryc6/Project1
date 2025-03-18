<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        *{
            margin: 0;
            padding: 0;
        }

       .body{
        width: auto;
        height: 287vh;
        background: lavender;
        margin-right: auto;
        margin-left: auto;
        position: relative;
       }

       .firstBoxForm{
        width: 1280px;
        height: 400px;
        box-sizing: border-box;
        background: white;
        margin-left: auto;
        margin-right: auto;
        border-radius: 10px;
        box-shadow: 0px 4px 10px rgba(0,0,0,.5);
        position: relative;
        margin-top: 50px;
       }

       .F-content{
        width: 700px;
        float: left;
        height: 380px;
        padding-left: 20px;
        padding-top: 20px;
        padding-bottom: 20px;
       }

       .title a{
        width: 100px;
        height: 30px;
        margin-right: 20px;
        text-align: center;
        padding-top: 3px;
        list-style: none;
        text-decoration: none;
        color: white;
        border-radius: 5px;
        background: darkgreen;
        float: right;
       }

        .app-ref-no{
            width: auto;
            height: 60px;
        }

        .app-ref-no input{
            width: 600px;
            height: 30px;
            font-family: Arial, Helvetica, sans-serif;
            padding-left: 5px;
            outline: none;
            border-top: none;
            border-left: none;
            border-right: none;
            border-bottom: 1px solid black;
            margin-left: 20px;
            
        }

        .school-campus{
            height: 50px;
            width: auto;

        }           

        .school-campus input{
            width: 250px;
            height: 30px;
            font-family: Arial, Helvetica, sans-serif;
            padding-left: 5px;
            outline: none;
            border-top: none;
            border-left: none;
            border-right: none;
            border-bottom: 1px solid black;
            margin-left: 45px;
            
        }

        .dg{
            margin-top: 20px;
            text-align: center;
            font-family: Arial, Helvetica, sans-serif;
        }

        .cam{
            margin-left: 40px;
        }

        .drop{
            margin-top: 20px;
            margin-left: auto;
            margin-right: auto;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .drop p{
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
        }

        .drop select{
            height: 30px;
            outline: none;
            border-top: none;
            border-left: none;
            border-right: none;
            border-bottom: 2px solid black;
            text-align: center;
        }

        .secondBox{
            margin-top: 30px;
            width: auto;
            height: 500px;
            background: white;
            width: 1280px;
            margin-left: auto;
            margin-right: auto;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0,0,0,.5);
        }

        .thirdBox{
            margin-top: 50px;
            width: auto; 
            height: 700px;
            background: white;
            width: 1280px;
            margin-left: auto;
            margin-right: auto;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0,0,0,.5);
        }

        .secondBox-content{
            width: auto;
            margin-left: auto;
            margin-right: auto;
            height: auto;   
        }

        .secondBox-content input{
            margin-top: 30px;
            width: 300px;
            height: 30px;
            margin-left: 10px;
            outline: none;
            border-top: none;
            border-left: none;
            border-right: none;
            border-bottom: 1px solid black;
        }

        .secondBox-content input::placeholder{
            font-family: Arial, Helvetica, sans-serif;
            font-style: italic;
            padding-left: 5px;
        }

        .secondBox-content p{
            padding-top: 10px;
            padding-left: 15px;
            font-size: medium;
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
        }

        .permanent-address p{
            margin-top: 15px;
        }

        .lastSchool-attended p{
            margin-top: 15px;
        }

        .applicant-info p{
            margin-top: 20px;
            height: 30px;
            width: auto;
            margin-left: auto;
            margin-right: auto;
        }

        .drop-down-birth{
            width: 1250px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 10px;
            height: 50px;
            position: relative;
            display: flex;
            justify-content: space-between;
        }
        
        .month select{
            height: 40px;
            width: 140px;
            border-top: none;
            border-right: none;
            border-left: none;
            border-bottom: 1px solid black;
            outline: none;
        }

        .day select{
            height: 40px;
            width: 100px;
            border-top: none;
            border-right: none;
            border-left: none;
            border-bottom: 1px solid black;
            outline: none;
            margin-left: -90px;
        }

        .year select{
            width: 100px;
            height: 40px;
            border-top: none;
            border-right: none;
            border-left: none;
            border-bottom: 1px solid black;
            outline: none;
            margin-left: -90px;
        }

        .list-sex select{
            width: 100px;
            height: 40px;
            border-top: none;
            border-right: none;
            border-left: none;
            border-bottom: 1px solid black;
            outline: none;
            margin-left: -40px;
        }

        .list-Status select{
            width: 100px;
            height: 40px;
            border-top: none;
            border-right: none;
            border-left: none;
            border-bottom: 1px solid black;
            outline: none;
            margin-left: -80px;
        }

        .drop-down-birth input{
            margin-top: 10px;
            margin-right: 60px;
        }
        
        .inputTown{
            width: 400px;
            float: left;
        }
        .inputTown input::placeholder{
            font-family: Arial, Helvetica, sans-serif;
            font-style: italic;
        }

        .thirdBox .first-comment{
            resize:  none;
            width: 800px;
            height: 100px;
            margin-left: 10px;
            margin-top: 8px;
            outline: none;
            padding-left: 10px;
            font-family: Arial, Helvetica, sans-serif;
        }

        .thirdBox .second-comment{
            resize: none;
            width: 800px;
            height: 100px;
            margin-top: 8px;
            outline: none;
            padding-left: 10px;
            font-family: Arial, Helvetica, sans-serif;
        }
        .third-content{
            width: auto;
            margin-left: auto;
            margin-right: auto;
            height: auto;
            position: relative;
        }

        .dl{
            font-family: Arial, Helvetica, sans-serif;
            margin-left: 10px;
            padding-top: 10px;
            font-weight: bold;
        }

        .first-question{
            margin-top: 20px;
            margin-left: 10px;
            margin-top: 30px;
            width: 540px;
        }

        .second-question{
            margin-left: 20px;
            margin-top: 20px;
            margin-right: auto;
        }

        .third-q{
            margin-left: 20px;
            font-family: Arial, Helvetica, sans-serif;
            margin-top: 100px;
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            font-weight: bold;
        }

        .I-certify{
            text-align: center;
            margin-top: 20px;
            font-style: italic;
        }

        .signature{
            text-align: center;
            margin-top: 80px;
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
        }

        .date{
            text-align: center;
            margin-top: 20px;
            font-family: Arial, Helvetica, sans-serif;
            font-weight: bold;
        }

       .hero{
        width: 400px;
        height: 400px;
        display: flex;
        align-items: center;
        justify-content: center;
        }

        .card{
            width: 400px;
            background: #fff;
            padding: 20px;
            border-radius: 15px;
            border: 1px solid black;
            background: green;
        }

        .card img{
            width: 350px;
            height: 230px;
            margin-left: auto;
            margin-right: auto;
            border-radius: 10px;
            margin-bottom: 30px;
            display: flex;
        }

        .hero label{
            width: 200px;
            height: 50px;
            background: yellow;
            box-shadow: 0px 4px 10px rgba(0,0,0,.5);
            cursor: pointer;
            display: flex;
            margin-right: auto;
            margin-left: auto;
            justify-content: center;
            font-family: Arial, Helvetica, sans-serif;
            border-radius: 10px;
        }

        label p{
            margin-top: 15px;
        }

        

        .hero input{
            display: none;
        }
      
        

       .text-area ::placeholder{
        font-style: italic;
        font-family: Arial, Helvetica, sans-serif;
       }     

       .text-area-sec ::placeholder{
        font-style: italic;
        font-family: Arial, Helvetica, sans-serif;
       }
    </style>

</head>


<body>
<div class="body">
        <!-------------------------------------------------------->
        <div class="title-logo">
            <div class="logo-here">
                <!--Picture-->
            </div>

            <div class="title">
                <h1>UNIVERSITY ADMMISION APPLICATION FORM</h1>
                <p class="title-p">
                    (Undergraduate Program)
                </p>

                
            </div>
        </div>
        <!-------------------------------------------------------->

        <div class="firstBoxForm">
            <div class="F-content">

                <form action="inputdataindatabase.php" method="post">
                    <button>Submit</button>
                    <div class="app-ref-no">
                        <input type="text" name="appno" placeholder="APP_REF NO." id="apprefno"> 
                    </div>

                    <div class="school-campus">
                        <input type="text" placeholder="SCHOOL YEAR" name="school_year" id="school_year">
                        <input type="text" placeholder="CAMPUS" class="cam" name="campus" id="campus">
                    </div>

                    <div class="degree-choice">
                        <p class="dg">DEGREE/PROGRAM CHOICES</p>
                        <div class="drop">
                            <p class="p-drop">FIRST CHOICE</p>
                            <select name="FIRSTCHOICE" id="FIRSTCHOICE" class="curse">
                                <option value="bachelorofscienceandinformationtechnologybsit">BACHELOR OF SCEINCE AND INFORMATION TECHNOLOGY (BSIT)</option>
                                <option value="bachelorofscienceandcomputerstudies">BACHELOR OF SCEINCE AND COMPUTER STUDIES (BSCS)</option>
                                <option value="bachelorofelementaryeducation">BACHELOR OF ELEMENTARY EDUCATION</option>
                                <option value="">BACHELOR OF SCIENCE </option>
                                <option value="">BACHELOR OF EARLY CHILDHOOD EDUCATION</option>
                                <option value=""></option> 
                            </select>
                        </div>

                        <div class="drop">
                            <p class="p-drop">SECOND CHOICE</p>
                            <select name="SECONDCHOICE" id="SECONDCHOICE" class="curse">
                                <option value="bachelorofscienceandinformationtechnologybsit">BACHELOR OF SCEINCE AND INFORMATION TECHNOLOGY (BSIT)</option>
                                <option value="bachelorofscienceandcomputerstudies">BACHELOR OF SCEINCE AND COMPUTER STUDIES (BSCS)</option>
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                            </select>
                        </div>

                        <div class="drop">
                            <p class="p-drop">SECOND CHOICE</p>
                            <select name="SECONDCHOICE" id="SECONDCHOICE" class="curse">
                                <option value="bachelorofscienceandinformationtechnologybsit">BACHELOR OF SCEINCE AND INFORMATION TECHNOLOGY (BSIT)</option>
                                <option value="bachelorofscienceandcomputerstudies">BACHELOR OF SCEINCE AND COMPUTER STUDIES (BSCS)</option>
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                             </select>
                        </div>

                        <div class="drop">
                            <p class="p-drop">THIRD CHOICE</p>
                            <select name="THIRDCHOICE" id="THIRDCHOICE" class="curse">
                                <option value="bachelorofscienceandinformationtechnologybsit">BACHELOR OF SCEINCE AND INFORMATION TECHNOLOGY (BSIT)</option>
                                <option value="bachelorofscienceandcomputerstudies">BACHELOR OF SCEINCE AND COMPUTER STUDIES (BSCS)</option>
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                                <option value=""></option>
                            </select>
                        </div>

                        <div class="hero">
                            <div class="card">
                                    <img src="pic/pro.jpg" id="profile-pic">
                                 <!--<label for="input-file">Choose Image</label>-->
                                 <label for="input-file" class="tt">
                                    <p>Insert Image (2x2)</p>
                                 </label>
                                <input type="file" accept="image/jpeg, image/png, image/jpg" id="input-file" name="sendpic">
                            </div>
                        </div>

                    
                        <div class="secondBox">
                            <div class="secondBox-content">
                                <p class="applicant-t">APPLICANT NAME(Please Print)</p>
                
                                <div class="applicant-name">
                                    <input type="text" placeholder="FAMILY NAME" name="familyname" id="familyname">
                                    <input type="text" placeholder="FIRST NAME" name="firstname" id="firstname">
                                    <input type="text" placeholder="MIDDLE NAME" name="middlename" id="middlename">
                                </div>
                
                                <div class="applicant-contact">
                                    <input type="email" placeholder="EMAIL ADDRESS" name="email" id="email">
                                    <input type="number" placeholder="CONTACT NUMBER" name="contactnumber" id="contactnumber">
                                </div>
                
                                <div class="applicant-info">
                                    <p class="birth">DATE OF BIRTH</p>
                                    <div class="drop-down-birth">
                
                                        <select name="birthmonth" id="birthmonth" class="d-month">
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
                
                                        
                                        <select name="daybirth" id="daybirth" class="d-day">
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
                                        
                
                                        
                                        <select name="yearbirth" id="yearbirth" class="d-year">
                                            <option value="1995">1995</option>
                                            <option value="1996">1996</option>
                                            <option value="1997">1997</option>
                                            <option value="1998">1998</option>
                                            <option value="1999">1999</option>
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
                                        
                
                                        
                                        <select class="seX" name="gender" id="gender">
                                            <option value="Male" >Male</option>
                                            <option value="Female" >Female</option>
                                        </select>
                                        
                
                                        <select class="relationship" name="relationship" id="relationship">
                                            <option value="Single">Single</option>
                                            <option value="Married">Married</option>
                                            <option value="Widowed">Widowed</option>
                                            <option value="Divorce">Divorce</option>
                                        </select>
                                        
                
                                        <div class="inputTown">
                                            <input type="text" placeholder="PLACE OF BIRTH(Town, Province)" name="placeofbirth" id="placeofbirth">
                                        </div>
                                    </div>
                                </div>
                
                                <div class="permanent-address">
                                    <p class="pd">PERMANENT ADDRESS</p>
                                    <input type="text" placeholder="BARANGAY" name="barangay" id="barangay"> 
                                    <input type="text" placeholder="MUNICIPALITY" name="municipality" id="municipality">
                                    <input type="text" placeholder="PROVINCE" name="province" id="province">
                                </div>
                
                                <div class="lastSchool-attended">
                                    <p class="la">LAST SCHOOL ATTENDED</p>
                                    <input type="text" placeholder="NAME OF SCHOOL" name="nameofschool" id="nameofschool">
                                    <input type="text" placeholder="ADDRESS" name="schooladdress" id="schooladdress">
                                    <input type="text" placeholder="YEAR" name="yearschool" id="yearschool">
                                    <input type="text" placeholder="GEN. AVERAGE" name="genaverage" id="genaverage">
                                </div>
                            </div>
                        </div>

                        <div class="thirdBox">
                            <div class="third-content">
                                <div class="first-question">
                                    <p class="dl">Declartion</p>
                                    <p class="first-question">Do you have a physical condition which may affect your performance in College?</p>
                
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
                                        <label class="yesNo">
                                            <input type="checkbox" name="seccheckboxyes" value="yes">
                                            <span class="checkmark"></span>
                                             Yes
                                          </label> 
                      
                                          <label class="yesNo">
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
                                  <p class="signature">SIGNATURE OVER PRINTED NAME</p>
                                  <p class="date">DATE</p>
                                </div>
                
                            </div>
                
                
                        </div>




                    </div>    
                </form>
            </div>
        </div>

        <!------------------------------------------------------------------------------------------------->

        

        
    </div>
    <script>
        let ProfilePic = document.getElementById("profile-pic");
        let InputFile = document.getElementById("input-file");  
        InputFile.onchange = function(){
            ProfilePic.src = URL.createObjectURL(InputFile.files[0]);
        }
    </script>
</body>
</html>