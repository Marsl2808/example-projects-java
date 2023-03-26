# Motivation
Wholesale object creation (not piecewise, unlike Builder) can be outsourced to:
<ul>
<li>A seperate fct (Factory Method)</li>
<li>that may exist in a seperate class (Factory)</li>
</ul>
Ctor is not descriptive:
<ul>
<li>Name mandated by name of containing type.</li>
<li>Cannot overload with same sets of args.</li>
<li>Can turn into "overloading hell".</li>
</ul>


# Summary
<ul>
<li>A factory method is a static method that creates objects.</li>
<li>A factory can be external or reside inside the object as an inner class.</li>
<li>Hierarchies of factories can be used to create related objects.</li>
</ul>
