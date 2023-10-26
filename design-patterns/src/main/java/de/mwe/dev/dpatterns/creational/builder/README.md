# Motivation
<ul>
<li>Having an object with 10 ctor arguments is not productive.</li>
</ul>

# Summary
<ul>
<li>A builder is a separate component for building an object.</li>
<li>Can either give a builder a ctor or return it via static function.</li>
<li>Return this to make builder fluent.</li>
<li>Different facets of an object can be built with different builders working in tandem via a base class.</li>
</ul>
