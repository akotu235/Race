param (
    [string]$reportFile,
    [string]$outputFile = ( [System.IO.Path]::ChangeExtension($reportFile, ".pdf"))
)

# Sprawdzenie, czy plik raportu istnieje
if (-Not (Test-Path $reportFile))
{
    Write-Host "Plik $reportFile nie istnieje."
    exit 1
}

# Generowanie PDF z podanego pliku Markdown
pandoc.exe $reportFile -o $outputFile --pdf-engine=xelatex -V geometry:a3paper -V geometry:margin=1in -V pagestyle=empty --highlight-style=tango

# Otwieranie wygenerowanego pliku PDF
Start-Process $outputFile

# SIG # Begin signature block
# MIIIWAYJKoZIhvcNAQcCoIIISTCCCEUCAQExCzAJBgUrDgMCGgUAMGkGCisGAQQB
# gjcCAQSgWzBZMDQGCisGAQQBgjcCAR4wJgIDAQAABBAfzDtgWUsITrck0sYpfvNR
# AgEAAgEAAgEAAgEAAgEAMCEwCQYFKw4DAhoFAAQUZ7p5Yqzd2idWIK5HSNBqkFiF
# CyagggT6MIIE9jCCAt6gAwIBAgIQYYPyfUBBC6pE/rAfOslXOzANBgkqhkiG9w0B
# AQsFADATMREwDwYDVQQDDAhha290dSBDQTAeFw0yMjA5MjAxOTQ4MDFaFw0zMjA5
# MjAxOTU4MDFaMBMxETAPBgNVBAMMCGFrb3R1IENBMIICIjANBgkqhkiG9w0BAQEF
# AAOCAg8AMIICCgKCAgEAvGcae/FCZugTbghxO7Qv9wQKvRvp9/WvJyJci/SIsPr1
# /Mf5wfBTJ3aCvyjFvHfcsDH4NdHZubHO531tc1NHCDh+Ztkr5hbOdl3x46nEXm6u
# e4Fiw23SB02dU3dAnFvNSGEE5jhQDOApGX/u7xEW4ZXrvMC5yLCBa3Kva1abPx5b
# owvQlHhiSsn039/K2xSNhR+x4QcgEIo9JYdcob0f7ZY3AhXT+f1PNyYe075SY+t2
# y1YMlPlq4THolVUB4yB5MknAOG7IoxFt0U9vXhMSjbb06LZ/I/2RpAJd/qcaC/aX
# CBvKYQbbmEqMqKutic/Q23cQU2jcuRxyy+Y5QphALwdkQGIuvOOIQCak/ZKa6k5S
# 5U3zcMSbGOFF1BHdLSmcUnicsuvMM4uOT0zF/yzuSv5fSo3t6W5VHa+1Ct8ygt3/
# Byq2dLPskUPn0khR3/PaC8Px0k6TpcL1auKeb/uObvckBH/NVvQebtFuXMFXCayw
# ZFQx2dGfqb20Q5ZDNw5u8PtrSAeTaqZ7shrcsHbi59ztASvNjapdnhosQ26ir5bD
# Urzn7Fm/R/tZ9wpCuZ6i2LErckKGMW0Lk1ku0HJv83q/rr0vkrbEXUWx6eaaXwQj
# IacKX8IvED/HN1gQ9WfkvLmQurF9ZUfJQDC/WNrIwYw4advSARKs/4WE+HmN1g0C
# AwEAAaNGMEQwDgYDVR0PAQH/BAQDAgeAMBMGA1UdJQQMMAoGCCsGAQUFBwMDMB0G
# A1UdDgQWBBSUHb/MW3YJQEoACPnV20ZgngOGCDANBgkqhkiG9w0BAQsFAAOCAgEA
# C6pw+UgUjitD9crDEpEPIcmC/Eiif7DnMI2xG1aS8drSFkTvJdmG1yI4gUigjncb
# LfDSLbUIwAUfaM6V1zPb/ec0dg0Nkn+Za1fpuIXxuPKtvrqr9FLfc70D3AphNrDD
# rFEd3c1ykLed7lllMYaLXkfWDRlxhhpP+LR9qbgvTxFbWk/7yA7kJrwEaDgfqqME
# QEE9xZDEIN/f1ycTnh0qmUwYoHDEKbOet/OgiILjzqIjplnaaKJIzFjmfDDK8JY+
# 0tl3hnyFHkPVe9sKTIEVhjc8XlaaCDDTEPTiWvB3TPMLZCqcwqQ4WdcWpS0Dp1Ms
# XvRVv8NkcDMPzFpgqFpkkrkqt94IESUycaAQe+czlurf/KiQjzAjVvhZFspqbBi8
# 83AZ9+mBQhtQqgzcZYSF2LAPbfTXCPw8daT/hOrUaU72YrA4ON64ZRYvcaj9u1AN
# +pxo8TY+YNak+tVByU3sfLfFwbJMJi63be1yo1yLc3b/d3DrJz3AIY82LrtdQcT3
# tj3QnyvVHpFvtzKZxO5hSgaTksmRBYJZ6cYcBgW69l8UpppiyAtzKo4AvD1XXlc6
# ehYjdBVms5F9spAWjwzXg9lWQSsul7V6WB7/PIaTF4hsZ9IylRl4FnBwcJbTdjXi
# E8oA77fIHMj6jOyxEeP6WGzjDYxBnLKyV/lVqk7WkqkxggLIMIICxAIBATAnMBMx
# ETAPBgNVBAMMCGFrb3R1IENBAhBhg/J9QEELqkT+sB86yVc7MAkGBSsOAwIaBQCg
# eDAYBgorBgEEAYI3AgEMMQowCKACgAChAoAAMBkGCSqGSIb3DQEJAzEMBgorBgEE
# AYI3AgEEMBwGCisGAQQBgjcCAQsxDjAMBgorBgEEAYI3AgEVMCMGCSqGSIb3DQEJ
# BDEWBBTSG/pKOlLO6wkcP+LiOaHk8M61ljANBgkqhkiG9w0BAQEFAASCAgCw/ytC
# YRCbD5r4JY9BrQ8xmMdiMTbdY+qokWZhgajOinRNNfa004m1zqLZZ/7sqo2x/ZSi
# HR0iLIa+vVQYK2bDfh4IBVVWX7TPn2i0hOIgl2mNlOuL2LFjtr4uG2VnlzDpcVyD
# 8fwTbfRQFbnU2GuGG2uOvYbMHm6IJ9Ncsnw8pdgYFpqiGN9+goJ6lfQlhyDDM5k+
# Hh4oPP9eAZc51z11KDeyHcspJ5FSatX64pv84VjVoS/HL2Po6zuoNYt95xmh9+cK
# v3Giy7FrVxUsDPS4B9fyfZbA7SCcO04ihZmy8wVH5EnTFVxiLBHkargHdBtCw7qk
# F2TM/ZPq3+cT/5IosE8EtYT1A0ql5FU/IcKDT0ltvGp9G09Pg5pbXYkVibxVktkR
# YXYYHQIpPWXugVYTqN5M6BfWQx9exjAcLSj03YR1nDPm7WNMLUjG10z9CPhzyLgs
# Z+dI5OlKcDXwivwLuHN+Fu8H+/wI6SUkYzhsv0XqYQemUtr5L8doOjcPRSZPEhdB
# XozEHbyJbgzj02O3DtlgQ6CJuaVlTAwoUxLr6LcfsS4MNo+uCswgw2z4J6ZARH4r
# bor0tCjp0D2aYQQLr30POVyJq5ReJnhDmAi4/vIJbftxM/vwaBz/I7G+Of7BLbTq
# bLkDqZyBg1hihBR+mpVo3jliOcxbkeuvaIxYDA==
# SIG # End signature block
