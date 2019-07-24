# Simple 1A2B Java Game
## Introduction
簡單的Java練習小程式<br>
只能用命令列執行<br>
玩法可以參見<br>
https://zh.wikipedia.org/wiki/猜数字#玩法

My simple Java practice program<br>
Only can run in the terminal(Or Windows command prompt)<br>
Can view https://en.wikipedia.org/wiki/Bulls_and_Cows to see how to play<br>
(Sorry for my bad English...)

## How to run program?
* 首先你需要有一個可以執行Java的環境，可以用下列指令來檢查。
  <pre><code>java -version</code></pre>
* 程式有兩個模式，可以透過載入引數來改變。
  執行指令如下
  * "電腦產生亂數"模式(不帶引數也是這個模式)：
    <pre><code>java -jar 1A2B.jar</code></pre>
    或
    <pre><code>java -jar 1A2B.jar rand</code></pre>
  * "手動輸入模式"，允許輸入答案，接著進行猜題，適合你出我猜的情境
    <pre><code>java -jar 1A2B.jar getnum</code></pre>

* First you need install Java or JDK on your computer. To check it you can use command below:
  <pre><code>java -jar 1A2B.jar</code></pre>
* This program has two modes. To change it you can add argument like this:
  <pre><code>java -jar 1A2B.jar</code></pre>
  or
  <pre><code>java -jar 1A2B.jar rand</code></pre>
  to start "Computer generated random numbers" mode, computer generate random number and guess it.
  <br><br>
  <pre><code>java -jar 1A2B.jar getnum</code></pre>
  to start "Manual input answer" mode, you can input answer number and other people to guess.
