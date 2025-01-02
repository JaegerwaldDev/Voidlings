execute unless entity @s[tag=voidlings.stabbed] run effect give @s minecraft:regeneration 3 5 true
execute if entity @s[tag=voidlings.stabbed] run function voidlings:valid_heart_replacement