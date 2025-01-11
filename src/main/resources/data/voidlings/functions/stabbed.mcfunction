playsound voidlings:entity.voidling.breath player @a ~ ~ ~ 0.75 1
execute unless entity @s[tag=voidlings.stabbed] run give @s voidlings:broken_voidling_heart 1

effect give @s minecraft:slowness 30 3 true
effect give @s minecraft:blindness 31 255 true

tag @s add voidlings.stabbed
tag @s remove voidlings.replaced_heart

schedule function voidlings:stabbed_bleed_out 600t replace