effect give @s minecraft:slowness 30 3 true
effect give @s minecraft:blindness 31 255 true

tag @s add voidlings.stabbed
tag @s remove voidlings.replaced_heart

schedule function voidlings:stabbed_bleed_out 600t replace