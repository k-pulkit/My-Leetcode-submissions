
<div>

<h2><a href="https://leetcode.com/problems/pyramid-transition-matrix/">756. Pyramid Transition Matrix</a></h2><h3>Medium</h3><hr><div><p>You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter. Each row of blocks contains <strong>one less block</strong> than the row beneath it and is centered on top.</p>

<p>To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed. A <strong>triangular pattern</strong> consists of a <strong>single block</strong> stacked on top of <strong>two blocks</strong>. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.</p>

<ul>
	<li>For example, <code>"ABC"</code> represents a triangular pattern with a <code>'C'</code> block stacked on top of an <code>'A'</code> (left) and <code>'B'</code> (right) block. Note that this is different from <code>"BAC"</code> where <code>'B'</code> is on the left bottom and <code>'A'</code> is on the right bottom.</li>
</ul>

<p>&nbsp;</p>

<p>You start with a bottom row of blocks bottom, given as a single string, that you <strong>must</strong> use as the base of the pyramid.</p>

<p>Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every <strong>triangular pattern</strong> in the pyramid is in allowed, or false otherwise.</p>

</div>