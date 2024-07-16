import React from 'react';
import {NavLink} from "react-router-dom";

const Menu = () => {
    return (
        <div>
            <ul className='menu'>
                <li>
                    <NavLink to={'/'}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={'/food'}>Food</NavLink>
                </li>
                <li>
                    <NavLink to={'/food/일누피'}>Food #1</NavLink>
                </li>
                <li>
                    <NavLink to={'/food/찰리야구방망이/커플'}>Food #2</NavLink>
                </li>
                <li>
                    <NavLink to={'/about'}>About</NavLink>
                </li>
                <li>
                    <NavLink to={'/about/Naver'}>About #2</NavLink>
                </li>
                <li>
                    <NavLink to={'/member'}>Member</NavLink>
                </li>
                <li>
                    <NavLink to={'/mycar/photo'}>MyCar</NavLink>
                </li>

            </ul>
        </div>
    );
};

export default Menu;