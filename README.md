# Information Security IA 1 
> This project is for Information Security course <br> <br>
> Prepared By : <br> Zenith Mehta (16010120028) 
<br> Parth Sangoi (16010120044) <br> Yash Salunke (16010120043) <br> Krish Bhat (16010120060)
<br> <br>
> Our Mentors :
Dr. Deepak Sharma ,
Prof. Zaheed Shaikh ,
Prof. Rajashree Daryapurkar
 <br>


<h2 id="table-of-contents"> Table of Contents</h2>
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#problemStatement">Problem Statement</a></li>
    <li><a href="#Installing">Installing bWAPP on kali</a></li>
    <li><a href="#Pentester">Downloading Web for Pentester </a></li>
    <li><a href="#BYPASSING">CAPTCHA BYPASSING</a> <ul>
        <li><a href="#">Method 1</a></li>
        <li><a href="#">Method 2</a></li>
        <li><a href="#">Method 3</a></li>
        <li><a href="#">Method 4</a></li>
       </ul></li>
    <li><a href="#fs">Conclusion</li>
    <li><a href="#rs">References</li>

  
  </ol>
</details>

<br>

<h4>  <a href="#">  </a> </h4>

<br>
<h1 id="problemStatement">Problem Statement</h1>
<p>
To Implement Captcha Bypassing with the help of Burp Suite Using 4 different methods.
</p>


<br>




<h1 id="Installing">Installing bWAPP on kali</h1>
<p>
-> bWAPP, or a buggy web application, is a free and open source deliberately insecure web application. 
<br> -> It helps security enthusiasts, developers and students to discover and to prevent web vulnerabilities.
<br>-> bWAPP prepares one to conduct successful penetration testing and ethical hacking projects.
 <br>-> It covers all major known web bugs, including all risks from the OWASP Top 10 project. <br>-> bWAPP is a PHP application that uses a MySQL database. <br>-> It can be hosted on Linux/Windows with Apache/IIS and MySQL. It can also be installed with WAMP or XAMPP.

 ![alt](/assets/1.png)
 ![alt](/assets/2.png)
 ![alt](/assets/3.png)
 ![alt](/assets/4.png)
  ![alt](/assets/5.png)
</p>

<br>
<br>

<h1 id="Pentester">Downloading Web for Pentester </h1>
<p>-> Web application penetration testing is the process of using penetration testing techniques on a web application to detect its vulnerabilities. <br> -> It is similar to a penetration test and aims to break into the web application using any penetration attacks or threats.


![alt](/assets/6.png)
![alt](/assets/7.png)
![alt](/assets/8.png)


</p>

<br>
<br>

<h1 id="BYPASSING">CAPTCHA BYPASSING</h1>
<p> Most of the time the attackers used brute force techniques to take over someone account, In such a technique, the server has to send a request to check the response But if captcha is applicable to web application and they are changing their value on every request then the attacker cannot perform the brute force attack, because captcha will applicable on login request of client.

<h2 id="Method_1"><b><i>Method 1</i></b></h2>
<p>-> bWAPP is the most well-known open-source vulnerable web application project designed to meet testing purposes.<br>-> Now we are going to use it to bypass captcha security.<br>->  We do not have credentials and the misfortune is that we are unable to perform any kind attack due to captcha. Now we will uses the burp suite and analyse the response then try to perform brute force attack to obtain the correct username and password. <br>-> First enter the correct captcha code and intercept the request. 

![alt](/assets/9.png)
<h3>After intercept the request send it on the intruder tab.<h3>
<br>

![alt](/assets/10.png)

<h3>Select the placement of the payload such as username and password.<h3>
<br>

![alt](/assets/11.png)

<h3>There are two payload lists and one of the two we have to enter the username.<h3>
<br>

![alt](/assets/12.png)

<h3>In the second payload list we will enter the password name. Lets start the attack.<h3>
<br>

![alt](/assets/13.png)
![alt](/assets/14.png)

<h3>We have successfully bypass the captcha security by giving the correct token at once.<h3>
<br>

![alt](/assets/15.png)

</p>
<br>

<h2 id="Method_2"><b><i>Method 2</i></b></h2>

<p>->We are using Pentester lab’s free practice lab
Captcha Bypass through Delete.
<br> -> Let’s start with find and exploiting captcha vulnerabilities with the first instance and here you can see the interface of the first instance.

![alt](/assets/16.png)

<h3>With the help of the source code, we saw that common logic is used in back-end coding which we can easily exploit. Let’s exploit it.<h3>
<br>

![alt](/assets/17.png)

<h3>For exploitation purposes we will use the burpsuite tool. Open the burpsuite, set the proxy and intercept the request. Through back-end coding we knew that it would be bypassed without giving captcha code.<h3>
<br>

![alt](/assets/18.png)

<h3>Now we will remove the captcha details completely and remove the request.<h3>
<br>

![alt](/assets/19.png)
![alt](/assets/20.png)

</p>



<br>

<h2 id="Method_3"><b><i>Method 3</i></b></h2>

<p>
-> Captcha Bypass through Tools
Sometimes the CAPTCHA code travels into the cookie, causing the attackers easily bypassed the security by creating tools. 
<br>-> Let’s analyse the response of the web application.

![alt](/assets/21.png)

<h3>We talk about this example and here you can see that the captcha code is in the cookie, although we can bypass it with the code given by the cookie, but this method will not apply during attacks, so we need a tool is required which will first receive the captcha code from cookies and then send a request for broken authentication.
<h3>
<br>


![alt](/assets/22.png)

<h3>After choosing one of the two methods, you will successfully bypass captcha protection.
<h3>

<br>


![alt](/assets/23.png)

</p>

<br>

<h2 id="Method_4"><b><i>Method 4</i></b></h2>

<h3>Similarly you can see that the captcha here is traveling in the URL and we will try to bypass it with the same technology. First we intercept the request.

<h3>

<br>

![alt](/assets/24.png)

<h3>
We observed that It does not bypass security by giving incorrect captcha details. Now we will placed own code.

<h3>

<br>


![alt](/assets/25.png)

<h3>
As you can see we had a breakthrough after placing our own code on both sides. Similarly if we want to break the authentication through brute force attack, then we use this technique to bypass captcha.
<h3>

<br>



![alt](/assets/26.png)



<br>
<h1 id="fs">Conclusion</h1>
By using CAPTCHAs and reCAPTCHAs, you can tell if a person is a robot or not. These checks are far from foolproof, but they can help prevent malicious bot activity.

<br>
<h1 id="rs">References</h1>
<p>
-> http://www.itsecgames.com/
<br>-> https://portswigger.net/burp
<br>-> https://secnhack.in/captchas-bypassing/
<br>-> https://www.wallarm.com/what/what-is-captcha-types-and-examples#how_attackers_defeat_captchas
<br>-> https://www.cashify.in/what-is-captcha
</p>


