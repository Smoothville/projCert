#!/bin/bash 


if [$(/opt/puppetlabs/bin/puppet cert list) ]
then
	/opt/puppetlabs/bin/puppet cert sign --all
else
       echo "already signed"
fi
