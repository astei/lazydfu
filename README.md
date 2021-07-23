# LazyDFU

LazyDFU is an optimization mod that makes the initialization of DataFixerUpper "lazy" - that is, it
will not immediately create the rules required to migrate data from older versions of Minecraft to
newer versions until it actually needs to do so. It does not modify DFU and should be safe, but do
exercise more than the usual caution.

The premise of LazyDFU is simple: most of the time, you will not need to convert data for every version
of the game. As a result, DFU rule compilation occurs later, when the game is already up and running.
This means it is possible you may see lag spikes if LazyDFU forces the game to compile migration rules,
but once complete there is no performance penalty.

## Give me the numbers!

On an i5-8250U laptop:

* Vanilla: ~58 seconds spent initializing DFU and compiling DFU rules
* LazyDFU: 498 **milliseconds** spent initializing DFU

This results in a smooth, responsive game startup.

## I want to see to believe it!

[Here's a video I recorded](https://www.youtube.com/watch?v=gXDqJ598kKA).

## Comparing it to other mods

### Cadmium

LazyDFU is complementary to Cadmium. While Cadmium tackles the root source of the problem (rule
optimization being slow), it only partially improves the situation. LazyDFU will still be highly
effective by deferring the initial compilation of DFU rules until needed, so the game will start
up much more quickly.

### Smooth Boot

LazyDFU takes a similar implementation approach to Smooth Boot: both mods do not try to modify DFU.
However, LazyDFU is superior to Smooth Boot as it does not compile DFU rules at all, which is the most
expensive part of the game startup process.

In comparison, Smooth Boot will instead limit the number of threads that compile DFU rules and run them
at a lower priority.

### DataBreaker

**DataBreaker is fundamentally unsafe**. If you load an older world with DataBreaker then **it will corrupt
that world**. There's some safeguards in DataBreaker, but even the author does not recommend using DataBreaker.
In comparison, with LazyDFU you may experience a nasty lag spike instead, which is vastly superior to having a
completely hosed world. So prefer LazyDFU over DataBreaker :)
